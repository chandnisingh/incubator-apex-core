/**
 * Copyright (c) 2012-2012 Malhar, Inc.
 * All rights reserved.
 */
package com.malhartech.stram.webapp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * Provides operator instance level data like id, container id, throughput, etc.<p>
 * <br>Current data includes<br>
 * <b>Node Id</b><br>
 * <b>Node Name</b><br>
 * <b>Container Id</b><br>
 * <b>Total Tuples processed</b><br>
 * <b>Total Bytes processed</b><br>
 * <b>Node Status</b><br>
 * <b>Last Heartbeat Time</b><br>
 * <br>
 *
 */

@XmlRootElement(name = "node")
@XmlAccessorType(XmlAccessType.FIELD)
public class OperatorInfo {

  public String id;
  public String name;
  public String container;
  public long totalTuples;
  public long totalBytes;
  public String status;
  public long lastHeartbeat;
  public long failureCount;
  public long lastCheckpoint;

  public OperatorInfo() {
  }

}
