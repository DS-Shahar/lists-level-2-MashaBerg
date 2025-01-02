
public class listsLevel2 {
	
	public static Node <Integer> q1(Node <Integer> h1, Node <Integer> h2)
	{
		Node <Integer> cur1 = h1;
		Node <Integer> cur2 = h2;
		
		Node <Integer> a1 = new Node <>(null); 
		Node <Integer> a2 = a1; 
		Node <Integer> a3 ;
		
		while (cur1 != null && cur2 != null)
		{
			if (cur1.getValue() >= cur2.getValue())
			{
				a3 = new Node <>(cur2.getValue());
				cur2 = cur2.getNext();
			}
			else
			{
				a3 = new Node <>(cur1.getValue());
				cur1 = cur1.getNext();
			}
			a2.setNext(a3);
			a2 = a3;
			
		}
		
		if (cur1 != null)
		{
			while (cur1 != null)
			{
				a3 = new Node <> (cur1.getValue());
				a2.setNext(a3);
				a2 = a3;
				cur1 = cur1.getNext();
			}
		}
		
		if (cur2 != null)
		{
			while (cur2 != null)
			{
				a3 = new Node <> (cur2.getValue());
				a2.setNext(a3);
				a2 = a3;
				cur2 = cur2.getNext();
			}
		}
		
		return a1.getNext();
	}
	
	public static Node <Integer> q2(Node <Integer> header)
	{
		Node <Integer> utility = new Node <> (null, header);
		Node <Integer> c ;
		Node <Integer> current ;
		int min;
		
		Node <Integer> a1 = new Node <>(null); 
		Node <Integer> a2 = a1; 
		Node <Integer> a3 ;
		
		
		
		while (utility.getNext() != null)
		{
			min = utility.getNext().getValue();
			c = utility.getNext().getNext();
			while (c != null)
			{
				if (min > c.getValue())
				{
					min = c.getValue();
				}
				c = c.getNext();
			}
			
			current = utility;
	        while (current.getNext() != null) 
	        {
	            if (current.getNext().getValue() == min) 
	            {
	                current.setNext(current.getNext().getNext());
	                break;
	            } 
	            else 
	            {
	                current = current.getNext();
	            }
	        }
			a3 = new Node <> (min);
			a2.setNext(a3);
			a2 = a3;
			
		}
		
		return a1.getNext();
	}

	public static int q3(Node <Integer> header, int num)
	{
		Node <Integer> current = header;
		
		int firstAppearance = -1;
		int lastAppearance = -1;
		int index = 0;
		
		while (current != null)
		{
			if (current.getValue() == num)
			{
				if (firstAppearance == -1)
				{
					firstAppearance = index ;
				}
				lastAppearance = index;
			}
			current = current.getNext();
			index ++;
			
		}
		if (firstAppearance == -1)
		{
			return -1;
		}
		
		int len = index;
		int distanceFromStart = firstAppearance;
		int distanceFromEnd = len- 1 - lastAppearance;
		
		int sum = distanceFromStart + distanceFromEnd ;
		
		return sum;
	}
	
	public static boolean q4(Node <Integer> header)
	{
		Node <Integer> current = header ;
		Node <Integer> check ;
		
		while (current != null)
		{
			check = current.getNext();
			while (check != null) 
			{
                if (current.getValue() == check.getValue()) {
                    return false; 
                }
                check = check.getNext();
            }
            current = current.getNext();
		}
		return true;
	}
	
	public static Node <Integer> q5(Node <Integer> header)
	{
		Node <Integer> current = header;
		Node <Integer> check ;
		
		Node <Integer> a1 = new Node <>(null); 
		Node <Integer> a2 = a1; 
		Node <Integer> a3 ;
		
		boolean flag ;
		
		while(current != null)
		{
			check = a1.getNext();
			flag = false;
			while (check != null) 
			{
                if (current.getValue() == check.getValue()) {
                	flag = true;
                	break ;
                }
                check = check.getNext();
            }
			if (flag == false) 
			{
				a3 = new Node <> (current.getValue()); 
				a2.setNext(a3);
				a2 = a3;
	        }
            current = current.getNext();
		}
		
		return a1.getNext();
	}
	
	public static void main(String[] args) {
		// Q1 - building lists:
		// ---- list 1 ----
		Node <Integer> a1 = new Node <> (1);
		Node <Integer> a2 = new Node <> (3);
		Node <Integer> a3 = new Node <> (3);
		Node <Integer> a4 = new Node <> (6);
		Node <Integer> a5 = new Node <> (7);
		a1.setNext(a2);
		a2.setNext(a3);
		a3.setNext(a4);
		a4.setNext(a5);
		// ---- list 2 ----
		Node <Integer> b1 = new Node <> (2);
		Node <Integer> b2 = new Node <> (2);
		Node <Integer> b3 = new Node <> (4);
		Node <Integer> b4 = new Node <> (5);
		b1.setNext(b2);
		b2.setNext(b3);
		b3.setNext(b4);
		// --- printing ----
		System.out.println(q1(a1, b1));
		
		
		// Q2 - building the list
		Node <Integer> c1 = new Node <> (4);
		Node <Integer> c2 = new Node <> (1);
		Node <Integer> c3 = new Node <> (6);
		Node <Integer> c4 = new Node <> (3);
		Node <Integer> c5 = new Node <> (5);
		c1.setNext(c2);
		c2.setNext(c3);
		c3.setNext(c4);
		c4.setNext(c5);
		// ---- printing ----
		System.out.println(q2(c1));
		
		
		// Q3 - building the list
		Node <Integer> d1 = new Node <> (2);
		Node <Integer> d2 = new Node <> (1);
		Node <Integer> d3 = new Node <> (5);
		Node <Integer> d4 = new Node <> (3);
		Node <Integer> d5 = new Node <> (1);
		d1.setNext(d2);
		d2.setNext(d3);
		d3.setNext(d4);
		d4.setNext(d5);
		// ---- printing ----
		System.out.println(q3(d1, 1));
		
		
		// Q4 - building the list
		Node <Integer> e1 = new Node <> (1);
		Node <Integer> e2 = new Node <> (2);
		Node <Integer> e3 = new Node <> (5);
		Node <Integer> e4 = new Node <> (4);
		Node <Integer> e5 = new Node <> (3);
		e1.setNext(e2);
		e2.setNext(e3);
		e3.setNext(e4);
		e4.setNext(e5);
		// ---- printing ----
		System.out.println(q4(e1));
		
		
		// Q4 - building the list
		Node <Integer> f1 = new Node <> (1);
		Node <Integer> f2 = new Node <> (2);
		Node <Integer> f3 = new Node <> (2);
		Node <Integer> f4 = new Node <> (4);
		Node <Integer> f5 = new Node <> (1);
		f1.setNext(f2);
		f2.setNext(f3);
		f3.setNext(f4);
		f4.setNext(f5);
		// ---- printing ----
		System.out.println(q5(f1));
	}

}
