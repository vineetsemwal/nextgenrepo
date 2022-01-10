import {Canvas,Square,Circle} from './Welcome';

export function startProject(){
  const shape=new Circle(5); 
  const canvas=new Canvas(shape);
  canvas.drawArea();
}

startProject();

//library