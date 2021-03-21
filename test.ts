let a:number[] = [1,2,3,4,5,6,7,8,9];
a.forEach((data,index)=>{
    console.log(data)
})
let b:number[] = a.map<number>((data,index):number=>{
    return data+1;
})
let c:number[] = a.filter((data:number)=>{
    return data>5;
})
let d:number = a.reduce((previousValue, currentValue, currentIndex, array):number=>{
    return previousValue+currentIndex;
},0)
for (const number of b) {
    console.log(number)
}
for (const number of a) {
    console.log(number)
}
console.log(d)