/*
 * eXist Open Source Native XML Database
 * Copyright (C) 2007-2009 The eXist Project
 * http://exist-db.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 *
 *  $Id$
 */
package org.exist.xquery.modules.httpclient;

import org.apache.commons.httpclient.methods.DeleteMethod;

import org.apache.log4j.Logger;

import org.exist.dom.QName;
import org.exist.xquery.FunctionSignature;
import org.exist.xquery.XPathException;
import org.exist.xquery.XQueryContext;
import org.exist.xquery.value.NodeValue;
import org.exist.xquery.value.Sequence;
import org.exist.xquery.value.SequenceType;

import java.io.IOException;


/**
 * Performs HTTP Delete method
 *
 * @author   Adam Retter <adam.retter@devon.gov.uk>
 * @author   Andrzej Taramina <andrzej@chaeron.com>
 * @version  1.3
 * @serial   20100228
 */
public class DELETEFunction extends BaseHTTPClientFunction
{
    protected static final Logger         logger    = Logger.getLogger( DELETEFunction.class );

    public final static FunctionSignature signature = 
		new FunctionSignature( 
			new QName( "delete", NAMESPACE_URI, PREFIX ), 
			"Performs a HTTP DELETE request." + " This method returns the HTTP response encoded as an XML fragment, that looks as follows: <httpclient:response xmlns:httpclient=\"http://exist-db.org/xquery/httpclient\" statusCode=\"200\"><httpclient:headers><httpclient:header name=\"name\" value=\"value\"/>...</httpclient:headers><httpclient:body type=\"xml|xhtml|text|binary\" mimetype=\"returned content mimetype\">body content</httpclient:body></httpclient:response>" + 
			" where XML body content will be returned as a Node, HTML body content will be tidied into an XML compatible form, a body with mime-type of \"text/...\" will be returned as a URLEncoded string, and any other body content will be returned as xs:base64Binary encoded data.", 
			new SequenceType[] {
            	URI_PARAM, PERSIST_PARAM, REQUEST_HEADER_PARAM
       		}, 
			XML_BODY_RETURN 
		);

	
    public DELETEFunction( XQueryContext context )
    {
        super( context, signature );
    }

	
    public Sequence eval( Sequence[] args, Sequence contextSequence ) throws XPathException
    {
        Sequence response = null;

        // must be a URL
        if( args[0].isEmpty() ) {
            return( Sequence.EMPTY_SEQUENCE );
        }

        //get the url
        String       url            = args[0].itemAt( 0 ).getStringValue();

        //get the persist state
        boolean      persistState 	= args[1].effectiveBooleanValue();

        //setup DELETE request
        DeleteMethod delete         = new DeleteMethod( url );

        //setup DELETE Request Headers
        if( !args[2].isEmpty() ) {
            setHeaders( delete, ( ( NodeValue )args[2].itemAt( 0 ) ).getNode() );
        }

        try {

            //execute the request
            response = doRequest(context, delete, persistState, null, null);
        }
        catch( IOException ioe ) {
            throw( new XPathException( this, ioe.getMessage(), ioe ) );
        }
        finally {
            delete.releaseConnection();
        }

        return( response );
    }
}
