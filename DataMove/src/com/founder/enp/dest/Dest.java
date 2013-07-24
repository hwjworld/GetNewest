/**
 * 
 */
package com.founder.enp.dest;

import java.util.List;

/**
 * @author Administrator
 *
 */
public interface Dest {
	public String geType();
	public void save(List<Object[]> list);
	public void open() throws Exception ;
	public void close();
}
