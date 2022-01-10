export class Canvas {

  public constructor(public shape:IShape){

  }

   drawArea(): void {
      const area = this.shape.area();
      console.log("drawing area ", area);
   }

}

interface IShape{
   area(): number;
}

export class Square implements IShape{

   constructor(public side: number) {

   }

   area(): number {
      return this.side * this.side;
   }

}


export class Circle implements IShape{

   constructor(public radius: number) {

   }

   area(): number {
      return 3.14* this.radius * this.radius;
   }

}