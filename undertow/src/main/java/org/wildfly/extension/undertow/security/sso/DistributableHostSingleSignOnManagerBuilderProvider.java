/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2017, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.wildfly.extension.undertow.security.sso;

import java.util.Optional;
import java.util.ServiceLoader;
import java.util.stream.StreamSupport;

import org.jboss.as.clustering.controller.CapabilityServiceBuilder;
import org.jboss.msc.service.ServiceName;

import io.undertow.security.impl.SingleSignOnManager;

/**
 * Builds a distrubutable {@link SingleSignOnManagerFactory} service.
 * @author Paul Ferraro
 */
public interface DistributableHostSingleSignOnManagerBuilderProvider {

    Optional<DistributableHostSingleSignOnManagerBuilderProvider> INSTANCE = StreamSupport.stream(ServiceLoader.load(DistributableHostSingleSignOnManagerBuilderProvider.class, DistributableHostSingleSignOnManagerBuilderProvider.class.getClassLoader()).spliterator(), false).findFirst();

    /**
     * Returns a builder of a SingleSignOnManagerFactory service for a host.
     * @param name the service name
     * @param serverName the name of the target server
     * @param hostName the name of the target host
     * @return builder for a service providing a {@link SingleSignOnManager}
     */
    CapabilityServiceBuilder<SingleSignOnManager> getBuilder(ServiceName name, String serverName, String hostName);
}
