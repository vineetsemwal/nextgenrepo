Create typescript project

1) create project directory

2) npm i typescript --save-dev

3)npx tsc --init // initializa project/create configuration

4) 
Add in tsconfig.json
 "outDir": "dist",
  "sourceMap": true

5)create simple index.ts

6)npx tsc src/index.ts //compile

7) now you can run generated js file with node