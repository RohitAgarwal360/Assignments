import java.io.*;
import java.util.*;

class pooltable {
int first,total_literals;
public pooltable(int f, int l) {
	this.first=f;
	this.total_literals=l;
	}
}

class obj {
	String name;
	int addr;
	obj(String nm, int address){
		this.name=nm;
		this.addr=address;
	}
}

class spos 
{
	static int pl=0;  //pool literal count
	static int pi;		//pool array index
	static int pa[] = new int [10];
   public static void main(String args[]) throws Exception  {
   	
	 String REG[] = {"ax","bx","cx","dx"};
	 String IS[]={"mover","movem","add","sub","div","mul"};
	 String DL[]={"ds","dc"};
	 obj[] literal_table = new obj[10];
	 obj[] symb_table = new obj[10];
	 obj[] optab =new obj[30];
	   
	 String line; 
	 try{
		 BufferedReader br=new BufferedReader(new FileReader("sample.txt"));
		 BufferedWriter bw=new BufferedWriter(new FileWriter("Output1.txt"));
		 BufferedWriter pool=new BufferedWriter(new FileWriter("pool"));
		 
		 
		 
		 Boolean start=false,end=false,fill_addr=false,ltorg=false;
	
	     int total_symb=0,total_ltr=0,optab_cnt=0,loc=0,temp,pos;
	     
	     
	     while((line=br.readLine())!=null&&!end)
	     {
	    	 String tokens[]=line.split(" ");
	    	 if(loc!=0 && !ltorg)
	    	 {
	    		 bw.write("\n"+String.valueOf(loc));
	    		 ltorg=false;
	    		 loc++;
	    	 }
	    	 ltorg=fill_addr=false;
	    	 for(int k=0;k<tokens.length;k++)
	    	 {
	    		 pos = -1;
	    		 if(start==true)
	    		 {
	    			 loc=Integer.parseInt(tokens[k]);
	    			 start=false;
	    		 }
	    		 
    			 switch(tokens[k])
				 {
    				 case "start" : start = true;
    				 				pos = 1;
				    				bw.write("\t(AD,"+pos+")");
		    				 		break;
    				 case "end": end=true;
    				 				pos = 2;
		    				 bw.write("\t(AD,"+pos+")");
		    				 for(temp=0;temp<total_ltr;temp++)
	    						 if(literal_table[temp].addr==0)
	    						 {
	    							 literal_table[temp].addr=loc-1;
	    		    				 bw.write("\t(DL,1)\t(L,"+(temp+1)+")"+"\n"+loc++);
	    						 }
	    						
	    						 pa[pi]=pl;
    				 			pi++;
    				 			pl=0;
    				 		 break;
    				 		 
    					 
    				 case "ltorg": ltorg=true;
    				 				pos = 4;
    				 			
    				 			pa[pi]=pl;
    				 			pi++;
    				 			pl=0;	
    				 				
    					 	 for(temp=0;temp<total_ltr;temp++)
	    						 if(literal_table[temp].addr==0)
	    						 {
	    							 literal_table[temp].addr=loc-1;
	    		    				 bw.write("\t(DL,1)\t(L,"+(temp+1)+")"+"\n"+loc++);
	    			 	
	    						 }
	    						
	    					 break;
    			
				 }
    			 if(pos == -1)
	    		 {
	    			 pos=search(tokens[k], IS);
	    			 if(pos != -1)
	    			 {
        				 bw.write("\t(IS,"+(pos+1)+")");
        				 optab[optab_cnt++]=new obj(tokens[k], pos);
        				 
	    			 }
	    			 else
			    	 {
			    		 pos=search(tokens[k], DL);
		    			 if(pos != -1)
		    			 {
		    			 
	                    int pos1 = search(tokens[k+1], symb_table,total_symb); 
		    			 	if (tokens[k].equals("dc")){
		    				 bw.write("\t(DL,"+(pos+1)+")"+"\t");
		    				 fill_addr=true;
		    				 symb_table[pos1].addr=loc-1;
		    				 }
		    				 
		    				 
		    				 if (tokens[k].equals("ds")){ 		    				 
		    				 bw.write("\t(DL,"+(pos+2)+")"+"\t");
		    				 symb_table[pos1].addr=loc-1; 
		    				 int val = Integer.parseInt(tokens[k+2]);
		    				 loc = loc+(val-1);
		    				 }
		    				 
		    				 
		    			 }
		    	
			    	 }
	    		 }
	    		 if(pos == -1) 
	    		 {
	    			 pos=search(tokens[k], REG);
	    			 if(pos!=-1)
	    				 bw.write("\t("+(pos+1)+")");
	    			 else
		    		 {
		    			 if(tokens[k].matches("='\\d+'"))
		    			 {
		    			 
			    			 literal_table[total_ltr++]=new obj(tokens[k], 0);
		    				 bw.write("\t(L,"+total_ltr+")");
			    		 	
			    		 	pl++; //increment pl on literal encounter
			    		 	
			    		 		
			    		 }
		    			 else if(tokens[k].matches("\\d+"))
	        				 bw.write("\t(C,"+tokens[k]+")");
		    			 else
		    			 {
		    				 pos = search(tokens[k], symb_table,total_symb);
		    				 if(fill_addr && pos!=-1)
							 {
								 symb_table[pos].addr=loc-1;
								 fill_addr=false;
							 }
		    				 else if(pos==-1)
		    				 {
		    					 symb_table[total_symb++]=new obj(tokens[k],0);
		    					 bw.write("\t(S," + total_symb + ")");
		    				 }
		    				 else
		    					 bw.write("\t(S," + pos + ")");
		    			 }
		    		 }
	    		 }
	    	 }
	     }
	     System.out.println("\n*************************************SYMBOL TABLE*************************************");
	     System.out.println("\nSYMBOL\tADDRESS");
	     for(int i=0;i<total_symb;i++)
	    	 System.out.println(symb_table[i].name+"\t"+symb_table[i].addr);
	     	 
	    
	     System.out.println("\n*************************************LITERAL TABLE*************************************");
	     System.out.println("\nIndex\tLITERAL\tADDRESS");
	     for(int i=0;i<total_ltr;i++)
	     {
	    	 if(literal_table[i].addr==0)
	    		 literal_table[i].addr=loc++;
	    	 System.out.println((i+1) +"\t"+literal_table[i].name+"\t"+literal_table[i].addr);
	     }
	     
	     System.out.println("\n*************************************OPTABLE*************************************");
	     System.out.println("\nMNEMONIC\tOPCODE");
	     for(int i=0;i<optab_cnt;i++)
	    	 System.out.println(optab[i].name+"\t\t"+optab[i].addr);
	     
	     br.close();
	     bw.close();
	 }
	 catch(Exception e)
	 {
	  System.out.println("error while reading the file");
	  e.printStackTrace();
	 }
	 BufferedReader br=new BufferedReader(new FileReader("Output1.txt"));
	 
	 System.out.println("\n***********************Output1.txt***********************\n");
	 

	 try {
		
		while((line=br.readLine())!=null)
				 System.out.println(line);
		
		br.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	System.out.println("\n***********************POOL TABLE***********************\n");
		
		for (int k=0 ; k<pa.length; k++)
		if	(pa[k]!=0)
		System.out.println(pa[k]);

	} 
	
	
	public static int search(String token, String[] list) {
		for(int i=0;i<list.length;i++)
			if(token.equalsIgnoreCase(list[i]))
				return i;
		return -1;
	}
	
	
	public static int search(String token, obj[] list,int cnt) {
			for(int i=0;i<cnt;i++)
				if(token.equalsIgnoreCase(list[i].name))
					return i;
		return -1;
	}
}  
