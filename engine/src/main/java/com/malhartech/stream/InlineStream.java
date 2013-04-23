/*
 *  Copyright (c) 2012 Malhar, Inc.
 *  All Rights Reserved.
 */
package com.malhartech.stream;

import com.malhartech.api.Sink;
import com.malhartech.engine.DefaultReservoir;
import com.malhartech.engine.SweepableReservoir;
import com.malhartech.engine.Stream;
import com.malhartech.engine.StreamContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Chetan Narsude <chetan@malhar-inc.com>
 */
/**
 *
 * Inline streams are used for performance enhancement when both the operators are in the same hadoop container<p>
 * <br>
 * Inline is a hint that the stram can choose to ignore. Stram may also convert a normal stream into an inline one
 * for performance reasons. A stream tagged with persist flag will not be inlined, as persistence requires a buffer
 * server<br>
 * Inline streams currently cannot be partitioned. Since the main reason for partitioning
 * is to load balance and that means across different hadoop containers. In future we may take a look at it.<br>
 * <br>
 *
 */
public class InlineStream extends DefaultReservoir implements Stream, SweepableReservoir
{
  private DefaultReservoir reservoir;

  public InlineStream(int capacity)
  {
    super("InlineStream", capacity);
  }

  /**
   *
   * @param context
   */
  @Override
  public void setup(StreamContext context)
  {
    setId(context.getId());
  }

  /**
   *
   * @param context
   */
  @Override
  public void activate(StreamContext context)
  {
  }

  /**
   *
   */
  @Override
  public void deactivate()
  {
  }

  /**
   *
   */
  @Override
  public void teardown()
  {
  }

  @Override
  public boolean isMultiSinkCapable()
  {
    return false;
  }

  @Override
  public void process(Object tuple)
  {
    try {
      put(tuple);
    }
    catch (InterruptedException ie) {
      logger.debug("Interrupted", ie);
    }
  }

  @Override
  public String toString()
  {
    return "InlineStream{" + "reservoir=" + reservoir + '}';
  }

  @Override
  public void setSink(String id, Sink<Object> sink)
  {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  private static final Logger logger = LoggerFactory.getLogger(InlineStream.class);
}
