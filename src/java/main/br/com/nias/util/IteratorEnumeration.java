package br.com.nias.util;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * An {@link Enumeration} implementation, that wraps an {@link Iterator}. Can
 * be used to integrate older APIs working with enumerations with iterators.
 *
 * @author Gunnar Morling
 * @param <T> The enumerated type.
 */
public class IteratorEnumeration <T> implements Enumeration<T> {

	private Iterator<T> source;

	
	public IteratorEnumeration(Iterator<T> source) {

		if ( source == null ) {
			throw new IllegalArgumentException( "Source must not be null" );
		}

		this.source = source;
	}

	public boolean hasMoreElements() {
		return source.hasNext();
	}

	public T nextElement() {
		return source.next();
	}
	
}