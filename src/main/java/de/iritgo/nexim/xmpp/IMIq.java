/**
 * This file is part of the neXim XMPP server
 *
 * Copyright (C) 2005-2011 Iritgo Technologies
 * Copyright (C) 2003-2005 BueroByte GbR
 * Copyright (c) 2003, OpenIM Project http://open-im.net
 *
 * Iritgo licenses this file to You under the BSD License
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * BSD License http://www.opensource.org/licenses/bsd-license.php
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.iritgo.nexim.xmpp;


import de.iritgo.nexim.tools.XMLToString;


public class IMIq implements Transitable
{
	public static final String TYPE_GET = "get";

	public static final String TYPE_SET = "set";

	public static final String TYPE_RESULT = "result";

	public static final String TYPE_ERROR = "error";

	private String m_type;

	private String m_to;

	private String m_id;

	private String m_from;

	private String m_data;

	private String m_error;

	private Integer m_errorCode;

	public final void setType (String type)
	{
		m_type = type;
	}

	public final String getType ()
	{
		return m_type;
	}

	public final void setTo (String to)
	{
		m_to = to;
	}

	public final String getTo ()
	{
		return m_to;
	}

	public final void setFrom (String from)
	{
		m_from = from;
	}

	public final String getFrom ()
	{
		return m_from;
	}

	public final void setId (String id)
	{
		m_id = id;
	}

	public final String getId ()
	{
		return m_id;
	}

	public final void setStringData (String data)
	{
		m_data = data;
	}

	public final void setError (String error)
	{
		m_error = error;
	}

	public void setErrorCode (int errorCode)
	{
		m_errorCode = new Integer (errorCode);
	}

	public String toString ()
	{
		XMLToString iq = new XMLToString ("iq");

		iq.addFilledAttribut ("to", m_to);
		iq.addFilledAttribut ("from", m_from);
		iq.addFilledAttribut ("type", m_type);
		iq.addFilledAttribut ("id", m_id);

		if (m_error != null)
		{
			XMLToString error = new XMLToString ("error");

			error.addTextNode (m_error);

			if (m_errorCode != null)
			{
				error.addFilledAttribut ("code", m_errorCode.toString ());
			}

			iq.addElement (error);
		}

		iq.addStringElement (m_data);

		return iq.toString ();
	}
}
