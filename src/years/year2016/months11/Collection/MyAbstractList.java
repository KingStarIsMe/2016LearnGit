package years.year2016.months11.Collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public abstract class MyAbstractList<E> extends MyAbstractCollection<E> implements
		List<E> {
	/**
	 * 构造
	 */
	protected MyAbstractList(){
	}
	/**
	 * 添加一个元素，在结尾
	 */
	public boolean add(E e){
		add(size(),e);
		return true;
	}
	/**
	 * 获取一个元素
	 */
	abstract public E get(int index);
	/**
	 * 修改一个位置的元素
	 */
	public E set(int index,E element){
		throw new UnsupportedOperationException();
	}
	/**
	 * 在指定位置添加元素
	 */
	public void add(int index,E element){
		throw new UnsupportedOperationException();
	}
	/**
	 * 删除指定位置的元素
	 */
	public E remove(int index){
		throw new UnsupportedOperationException();
	}
	/**
	 * 返回元素在当前集合中的第一个位置
	 */
	public int indexOf(Object o){
		ListIterator<E> e = listIterator();
		if(o==null){
			while(e.hasNext()){
				if(e.next()==null){
					return e.previousIndex();
				}
			}
		}else{
			while(e.hasNext()){
				if(o.equals(e.next())){
					return e.previousIndex();
				}
			}
		}
		return -1;
	}
//	public int lastIndexOf(Object o){
//		ListIterator<E> e = listIterator(size());
//	}
}
