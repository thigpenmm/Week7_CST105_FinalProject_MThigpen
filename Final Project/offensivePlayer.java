/*Program: offensivePlayer Program
 *File: offensivePlayer.java
 *Summary: Identifies new offensive player info based on abstract NFLPlayerManager class 
 * and offensivePlayer subclass.
 *Author: Mercedes Thigpen
 *Date: March 30, 2018
 **/
package MyFinalProject;

import javafx.scene.control.CheckBox;

public class offensivePlayer extends NFLPlayerManager {//extending the abstract class
   int yards;//identifying the new variables of the defensivePlayer subclass
   int receptions;
   int touchdowns;
   private CheckBox select;
   

    public offensivePlayer(String name, String position, int yards, int receptions, int touchdowns) {
        super(name, position);//inherited variables from the abstract NFLPlayerMgr class
        this.yards = yards;//new variables of the offensivePlayer class
        this.receptions = receptions;
        this.touchdowns = touchdowns;
        this.select = new CheckBox();
   
        // Getters and Setters for each variable //        
    }
    public String getName(){
            return name;
    }
    public void setName(String name){
        this.name = name;
    }
   public String getPosition(){
            return position;
    }
    public void setPosition(String position){
        this.position = position;
    }
    public int getYards(){
            return yards;
    }
    public void setYards(int yards){
        this.yards = yards;
    }              
    public int getReceptions(){
            return receptions;
    }
    public void setReceptions(int receptions){
        this.receptions = receptions;
    }
    public int getTouchdowns(){
            return touchdowns;
    }
    public void setTouchdowns(int touchdowns){
        this.touchdowns = touchdowns;
    }
    public CheckBox getSelect(){
            return select;
    }
    public void setSelect(CheckBox select){
        this.select = select;
    }
    
    @Override
    public void performance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }

   
    

   

