
function add(num1, num2) {
    // console.log("inside add");
    let promise = new Promise((resolve, reject) => {
        console.log("inside Promise handler function");
        if (!num1 || !num2) {
            reject(new Error("num1 or num2 is undefined"));
        }
        setTimeout(() => {
            let result = num1 + num2;
            resolve(result);
        }, 5000);

    });
    return promise;
}

async function waitForAdd(num1, num2) {
    console.log("inside wait for add");
    let promise = add(num1, num2);
    console.log("before wait", new Date());
    let result = await promise;
    console.log("after await", new Date());
    console.log("after await", result)
    return result;
}

function useAdd() {
    console.log("promise to be created");
    let promise = waitForAdd(10, 20);
    console.log("promise created");
    const successHandler = result => {
        console.log("result is available ", result);
    };
    const errHandler = err => {
        console.log("error was there");
        console.log(err.message);
    };
    promise.then(successHandler, errHandler);
    console.log("bye");
}

useAdd();
