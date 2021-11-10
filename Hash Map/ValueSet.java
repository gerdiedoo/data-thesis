/**
 *
 * This file is part of the Persistent-HashMap library.
 * Copyright (C) 2010 Jamie Furness (http://www.jamierf.co.uk)
 * License: http://www.gnu.org/licenses/gpl.html GPL version 3 (or higher)
 *
 */

package com.jamierf.persistenthashmap;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

class ValueSet<K extends Serializable, V extends Serializable> extends AbstractSet<V> {

	private PersistentHashMap<K, V> map;

	public ValueSet(PersistentHashMap<K, V> map) {
		this.map = map;
	}

	@Override
	public boolean contains(Object o) {
		return map.containsValue(o);
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean containsAll(Collection<?> c) {
		Collection<V> ec = (Collection<V>) c;
		for (V value : ec)
			if (!contains(value))
				return false;

		return true;
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public Iterator<V> iterator() {
		return new ValueIterator<K, V>(map);
	}

	@Override
	public int size() {
		return map.size();
	}
}
