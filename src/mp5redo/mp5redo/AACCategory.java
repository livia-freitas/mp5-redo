package mp5;

/**
 * Author: Livia Stein Freitas. 
 * Class description from the assignment website at https://accessibilityeducation.github.io/assignments/AAC/AAC.html
 * 
 * This portion of the AAC represents a single category of items in the AAC. It stores the mapping between the image 
 * location and the text that should be spoken and the name of the category.
 */

public class AACCategory {
  
  AssociativeArray<String,String> mappings;
  String name;

  public AACCategory(String _name){
    this.name = _name;
    this.mappings = new AssociativeArray<>();
  }

  /**
   * Adds the mapping of the imageLoc to the text to the category.
   */
  public void addItem(String imageLoc, String text){
    this.mappings.set(imageLoc, text);
  }

  /**
   * Returns the name of the category
   */
  public String getCategory(){
    return this.name;
  }

  /**
   * Returns an array of all the images in the category
   * @return
   */
    public String[] getImages(){
      String[] imageArray = new String[this.mappings.size()];
      int n = 0; // n keeps track of the index of non-null elements 
      for (int i = 0; i < this.mappings.pairs.length; i++) { // i makes sure that it loops through the entire associative array
        if(this.mappings.pairs[i] == null){
          continue;
        } else {
          imageArray[n] = this.mappings.pairs[i].key;
          n++;
        } 
      } // for
    return imageArray;
  }

  /**
   * Returns the text associated with the given image loc in this category
   */
    public String getText(String imageLoc) throws KeyNotFoundException {
      if (this.mappings.hasKey(imageLoc)){
        return this.mappings.get(imageLoc);
      } else {
        throw new KeyNotFoundException();
      }
  }

  /**
   * Determines if the provided image is stored in the category
   */
  public boolean hasImage(String imageLoc){
    return this.mappings.hasKey(imageLoc);
  }
  
}
