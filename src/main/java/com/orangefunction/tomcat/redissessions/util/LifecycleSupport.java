package com.orangefunction.tomcat.redissessions.util;

import org.apache.catalina.Lifecycle;
import org.apache.catalina.LifecycleEvent;
import org.apache.catalina.LifecycleListener;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class LifecycleSupport
{
  private final Lifecycle lifecycle;
  
  public LifecycleSupport(Lifecycle lifecycle)
  {
    this.lifecycle = lifecycle;
  }
  
  private final List<LifecycleListener> listeners = new CopyOnWriteArrayList();
  
  public void addLifecycleListener(LifecycleListener listener)
  {
    this.listeners.add(listener);
  }
  
  public LifecycleListener[] findLifecycleListeners()
  {
    return (LifecycleListener[])this.listeners.toArray(new LifecycleListener[0]);
  }
  
  public void fireLifecycleEvent(String type, Object data)
  {
    LifecycleEvent event = new LifecycleEvent(this.lifecycle, type, data);
    for (LifecycleListener listener : this.listeners) {
      listener.lifecycleEvent(event);
    }
  }
  
  public void removeLifecycleListener(LifecycleListener listener)
  {
    this.listeners.remove(listener);
  }
}