package mp5redo;
import java.io.FileWriter;   
import java.io.IOException;  

/**
 * Author: Livia Stein Freitas. 
 * Class description from the assignment website at https://accessibilityeducation.github.io/assignments/AAC/AAC.html
 * 
 * This is the class the keeps track of the complete set of AAC mappings. It will store the mapping of the images 
 * on the home page to the AACCategories. The class should keep track of the current category that is being displayed. 
 * Then given the current category ("" if the home screen or the category name for any other category),
 * it should respond appropriately for each of the methods.
 */
public class AACMappings {
  
  AACCategory currentCategory;
  AACCategory defaultCategory;
  AssociativeArray<String, AACCategory> mappings;

  public AACMappings(){
    this.defaultCategory = new AACCategory("default");
    this.currentCategory = defaultCategory;
    this.mappings = new AssociativeArray<String, AACCategory>(); //creates an array that maps categories to their arrays of images
  }

  /**
   * Adds the mapping to the current category (or the default category if that is the current category)
   */
  public void add(String imageLoc, String text){
    this.currentCategory.mappings.set(imageLoc, text);
  }

  /**
   * Gets the current category
   */
  public String getCurrentCategory(){
    return this.currentCategory.name;
  }

  /**
   * Provides an array of all the images in the current category
   */
  public String[] getImageLocs(){
    return this.currentCategory.getImages();
  }

  /**
   * Given the image location selected, it determines the associated text with the image.
   */
  public String getText(String imageLoc) throws KeyNotFoundException{
    for(int i = 0; i < this.mappings.pairs.length; i++){
      if(this.mappings.pairs[i] == null){
        continue;
      } else if (this.mappings.pairs[i].value.hasImage(imageLoc)){
        return this.mappings.pairs[i].value.getText(imageLoc);
      } //if
    }//for
    throw new KeyNotFoundException();
  }

  /**
   * Determines if the image represents a category or text to speak
   */
  public boolean isCategory(String imageLoc){
      for(int i = 0; i < this.mappings.pairs.length; i++){
        if(this.mappings.pairs[i] == null){
          continue;
        } else if (this.mappings.pairs[i].value.name.equals(imageLoc)){
          return true;
        } //if
      }//for
    return false;
  }//isCategory

  /**
   * Resets the current category of the AAC back to the default category
   */
  public void reset(){
    this.currentCategory = this.defaultCategory;
  }

  /**
   * Writes the ACC mappings stored to a file.
   * @param filename
   */
  public void writeToFile(String filename){
    try {
      FileWriter writerTool = new FileWriter(filename);
      for(int i = 0; i < this.mappings.pairs.length; i++){
        if(this.mappings.pairs[i] == null){
          continue;
        } else {
          writerTool.write("\n" + this.mappings.pairs[i].key + ", " + this.mappings.pairs[i].value);
        } 
      writerTool.close();
      System.out.println("Wrote to " + filename + " successfully.");
      }//for
    } catch (IOException e) {
    System.out.println("Could not print to " + filename + ". Will print stack trace.");
    e.printStackTrace();
    }//catch
  }//writeToFile
}//AACMappings
