//inheritance 2 (multi level)
package cs502;
public class Test2 {
    public static void main(String[] args) {
        All all;
        
        int x;
        int a;
    	int b;
    	int c;
        
        
        all = new All();
        a = all.m1();
		b = all.m4();
		c = all.m3();
		x = all.m411();
		
  		System.out.println(x); 
    }
}

class One {
	int v1;
	
	public int m1(){
    	v1 = 1;
        System.out.println(v1);
        return v1;
    }
}
 
class Four extends One {
	int v2;
	
	public int m4() { 
		v2 = 4;
    	System.out.println(v2); 
    	return v2;
    }
}

class Three extends Four {
	int v3;
	
	public int m3() { 
		v3 = 3;
		System.out.println(v3); 
		return v2;
    }
}

class All extends Three {
	int all;
	
    public int m411() { 
		all = 411;
		return all;
    }
    
}


