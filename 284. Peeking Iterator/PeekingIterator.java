// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
import java.util.Iterator;
import java.util.ArrayList;
class PeekingIterator implements Iterator<Integer> {
	private Iterator<Integer> iter;
	private Integer next;
	private Boolean done;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
		iter = iterator;
		if (iter.hasNext()) {
			next = iter.next();
			done = false;
		} else {
			next = null;
			done = true;
		}
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		int result = next;
		if (iter.hasNext()) {
			next = iter.next();
		} else {
			next = null;
			done = true;
		}

		return result;
	}

	@Override
	public boolean hasNext() {
		return !done;
	}

	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(1);
		array.add(2);
		PeekingIterator iter = new PeekingIterator(array.iterator());
	    System.out.println(iter.next()); //1
	    System.out.println(iter.hasNext()); //true
	    System.out.println(iter.peek()); //2
	    System.out.println(iter.next()); //2
	    System.out.println(iter.hasNext()); //false
	}
}

// Solution 2:
import java.util.ArrayDeque;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
  private ArrayDeque<Integer> deque;

  public PeekingIterator(Iterator<Integer> iterator) {
      // initialize any member here.
      deque = new ArrayDeque();
      while (iterator.hasNext()) {
          deque.offer(iterator.next());
      }
  }

    // Returns the next element in the iteration without advancing the iterator.
  public Integer peek() {
      return deque.peek();
  }

  // hasNext() and next() should behave the same as in the Iterator interface.
  // Override them if needed.
  @Override
  public Integer next() {
      return deque.pop();
  }

  @Override
  public boolean hasNext() {
      return !deque.isEmpty();
  }
}
