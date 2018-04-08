package MyFinalProject;

/**Program: NFLPlayerManager Program
 *File: NFLPlayerManager.java
 *Summary: Prints listing of NFL Players and positions
 *Author: Mercedes Thigpen
 *Date: March 24, 2018
 **/

// This is my own work <Mercedes Thigpen>


      // begin NFLPlayerMgr program class  
public abstract class NFLPlayerManager {
  String name; //adding variables of the NFLPlayerMgr class
  String position;

  
  public NFLPlayerManager(String name, String position){
      this.name = name; //naming the variables for the NFLPlayerMgr class
      this.position = position;
      
  }

 abstract public void performance();// declaring performance as an abstract method. 
 //performance is measured for each NFL player, but differs based on their role.
 public void stats(){
  
 }


}
 
   
