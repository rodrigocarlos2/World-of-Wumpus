package wumpustest;

import java.io.IOException;
import java.util.Scanner;

public class WumpusTest{

    public static void main(String[] args) throws IOException {
    	
        WumpusWorld aWorld = new WumpusWorld(5);
        
        Scanner scanner = new Scanner(System.in);  
        
        aWorld.randomise(0.2, false);
        
        aWorld.startSimulation();
        
        while(true)
        {   
            aWorld.print(System.out);
            
            if(aWorld.agentFoundGold()){
            
            	aWorld.setScoreAgent(1000);
            	
            	System.out.println("Score of Agent: "+aWorld.getScoreAgent());
            	
                System.out.println("Agent won...");                
                break;
                
            }
            
            if(aWorld.agentDied()){
            	
            	aWorld.setScoreAgent(-1000);
            	
            	System.out.println("Score of Agent: "+aWorld.getScoreAgent());
            	
                System.out.println("Agent died...");
                break;
                
            }

            System.out.println("Score of Agent: "+aWorld.getScoreAgent());
            
            try {
				Thread.sleep(2100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            String f = aWorld.moveAgent();
            
            if(f.equals("F")){
            	aWorld.setScoreAgent(-1);
            }
            
        }
         
    }
}
