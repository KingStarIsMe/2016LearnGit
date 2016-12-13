package years.year2016.months11.Collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public abstract class MyAbstractCollection<E> implements Collection<E>{
	
	protected MyAbstractCollection(){}
	public abstract Iterator<E> iterator();
	/**
	 * 获取集合中数据项数量
	 */
	public abstract int size();
	/**
	 * 判定集合中是否没有数据项
	 */
	public boolean isEmpty(){
		return size()==0;
	}
	/**
	 * 判定是否包含某个数据元素
	 */
	public boolean contains(Object o){
		Iterator<E> e = iterator();
		if(o==null){
			while(e.hasNext()){
				if(e.next()==null){
					return true;
				}
			}
		}else{
			while(e.hasNext()){
				if(o.equals(e.next())){
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * 将数据转换为数组
	 */
	public Object[] toArray(){
		Object[]r = new Object[size()];
		Iterator<E> it = iterator();
		for(int i=0,l=r.length;i<l;i++){
			if(!it.hasNext()){
				return Arrays.copyOf(r, i);
			}
			r[i]=it.next();
		}
		return it.hasNext()?finishToArray(r, it):r;
	}
	/**
	 * 将数据转换为数组
	 */
	public <T>T[] toArray(T[]a){
		int size = size();
		T[]r = a.length>=size?a:(T[])java.lang.reflect.Array
				.newInstance(a.getClass().getComponentType(), size);
		Iterator<E> it =iterator();
		for(int i=0,l=r.length;i<l;i++){
			if(!it.hasNext()){
				if(a!=r){
					return Arrays.copyOf(r, i);
				}
				r[i]=null;
				return r;
			}
			r[i]=(T)it.next();
		}
		return it.hasNext()?finishToArray(r, it):r;
		
	}
	/**
	 * 将数据转入数组中进行返回
	 * @param <T>
	 * @param r
	 * @param it
	 * @return
	 */
	private static <T>T[] finishToArray(T[]r,Iterator<?>it){
		int i = r.length;
		while(it.hasNext()){
			int cap = r.length;
			if(i==cap){
				int newCap = ((cap/2)+1)*3;
				if(newCap<=cap){
					if(cap == Integer.MAX_VALUE){
						throw new OutOfMemoryError();
					}
					newCap = Integer.MAX_VALUE;
				}
				r = Arrays.copyOf(r, newCap);
			}
			r[i++]=(T)it.next();
		}
		return (i==r.length)?r:Arrays.copyOf(r, i);
	}
	/**
	 * 添加一个元素
	 */
	public boolean add(E e){
		throw new UnsupportedOperationException();
	}
	/**
	 * 删除一个元素
	 */
	public boolean remove(Object o){
		Iterator<E> e = iterator();
		if(o==null){
			while(e.hasNext()){
				if(e.next()==null){
					e.remove();
					return true;
				}
			}
		}else{
			while(e.hasNext()){
				if(o.equals(e.next())){
					e.remove();
					return true;
				}
			}
		}
		return false;
	}
	public boolean containsAll(Collection<?>c){
		Iterator<?>e = c.iterator();
		while(e.hasNext()){
			if(!contains(e.next())){
				return false;
			}
		}
		return true;
	}
	/**
	 * 添加c集合中的所有元素到当前的数据中
	 */
	public boolean addAll(Collection<? extends E> c){
		boolean modified = false;
		Iterator<? extends E>e = c.iterator();
		while(e.hasNext()){
			if(add(e.next())){
				modified = true;
			}
		}
		return modified;
	}
	/**
	 * 从当前集合中删除所有的c元素
	 */
	public boolean removeAll(Collection<?>c){
		boolean modified = false;
		Iterator<?>e = iterator();
		while(e.hasNext()){
			if(c.contains(e.next())){//如果在当前的集合中有c中的元素，则从当前集合中删除这个元素
				e.remove();
				modified=true;
			}
		}
		return modified;
	}
	/**
	 * 删除当前集合中不包含的元素
	 */
	public boolean retainAll(Collection<?>c){
		boolean modified = false;
		Iterator<E>e = iterator();
		while(e.hasNext()){
			if(!c.contains(e.next())){//如果当前元素在c集合中没有则删除
				e.remove();
				modified=true;
			}
		}
		return modified;
	}
	/**
	 * 删除集合中所有元素
	 */
	public void clear(){
		Iterator <E> e=iterator();
		while(e.hasNext()){
			e.next();
			e.remove();
		}
	}
	/**
	 * 返回String
	 */
	public String toString(){
		Iterator<E> i =iterator();
		if(!i.hasNext()){
			return "[]";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(;;){
			E e = i.next();
			sb.append(e==this?"(this Colection)":e);
			if(!i.hasNext()){
				return sb.append("]").toString();
			}
			sb.append(",");
		}
	}
	
}
