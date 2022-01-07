/**
 *  any constant like lack will give color hex value, string value
 * + all the constants for a particular type 
 * 
 */
class Color{

   static readonly  Black:Color=new Color('Black','#000');

   static readonly White:Color=new Color('White',"#fff");

    static readonly colors:Color[]=[Color.Black, Color.White];
   
   private constructor(private colorName:string, private colorValue:string){

    }

    getColorName():string{
        return this.colorName;
    }

    getColorValue():string{
        return this.colorValue;
    }

   static getAll():Color[]{
        return Color.colors;
    }

}

let black=Color.Black;
console.log("name =",black.getColorName(),"value",black.getColorValue());
console.log(black);

let white=Color.White;
console.log("name =",white.getColorName(),"value",white.getColorValue());
console.log(white);
console.log("all colors below")
let colors:Color[]=Color.getAll();
for(let color of colors){
    console.log(color.getColorName(), color.getColorValue());
}

