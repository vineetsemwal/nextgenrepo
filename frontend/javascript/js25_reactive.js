
function add(num1, num2) {
    console.log("inside add");

    if (!num1 || !num2) {
        let promise = Promise.reject(new Error("number 1 or number 2 is undefined"));
        return promise;
    }
   
    let result = num1 + num2;
    let promise = Promise.resolve(result);
    return promise;
}

function useAdd() {
    console.log("promise to be created");
    let promise = add(3, 5);
    console.log("promise created");
    promise.then(result => {
        console.log("result is available ", result);
    },
        err => {
            console.log("error was there");
            console.log(err.message);
        }
    );
    console.log("bye");
}

useAdd();
