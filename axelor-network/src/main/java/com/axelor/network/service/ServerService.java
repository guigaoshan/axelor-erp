/**
 * Copyright (c) 2012-2014 Axelor. All Rights Reserved.
 *
 * The contents of this file are subject to the Common Public
 * Attribution License Version 1.0 (the “License”); you may not use
 * this file except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://license.axelor.com/.
 *
 * The License is based on the Mozilla Public License Version 1.1 but
 * Sections 14 and 15 have been added to cover use of software over a
 * computer network and provide for limited attribution for the
 * Original Developer. In addition, Exhibit A has been modified to be
 * consistent with Exhibit B.
 *
 * Software distributed under the License is distributed on an “AS IS”
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See
 * the License for the specific language governing rights and limitations
 * under the License.
 *
 * The Original Code is part of "Axelor Business Suite", developed by
 * Axelor exclusively.
 *
 * The Original Developer is the Initial Developer. The Initial Developer of
 * the Original Code is Axelor.
 *
 * All portions of the code written by Axelor are
 * Copyright (c) 2012-2014 Axelor. All Rights Reserved.
 */
package com.axelor.network.service;

import java.io.IOException;
import java.net.InetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.axelor.apps.network.db.Server;

public class ServerService {

	private final static int TIME_OUT = 2000;
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	public boolean isReachable( Server server ) {

		logger.debug("{} is reachable ?", server);
		try {
			InetAddress inetAddress = InetAddress.getByName( server.getInetAddress());
			return inetAddress.isReachable( TIME_OUT );
		} catch ( IOException e ) {	return false; }
		
	}

	public String getHostName( Server server ) {

		logger.debug("{} is getHostName.", server);
		try {
			InetAddress inetAddress = InetAddress.getByName( server.getInetAddress());
			return inetAddress.getHostName();
		} catch ( IOException e ) {	return server.getHostName(); }
		
	}
	
}
