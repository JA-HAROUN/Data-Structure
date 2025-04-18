public interface Stack {

    public void push(Object element);
    
    public Object pop();
    
    public Object top();
    
    public boolean isEmpty();
    
    public int size();

    public void clear();

    public boolean contains(Object element);

    public Stack copy();

}