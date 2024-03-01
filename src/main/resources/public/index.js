function calcularSeno(){
    let inputSeno = document.getElementById("seno");
    let endPoint = "/sin?numero=" + inputSeno.value;
    let peticion = solicitarEndPoint(endPoint);
    peticion.then((respuesta) => {
        let divSenoResult = document.getElementById("senoResult");
        divSenoResult.innerHTML = respuesta;
    });
}

function calcularCoseno(){
    let inputCoseno = document.getElementById("coseno");
    let endPoint = "/cos?numero=" + inputCoseno.value;
    let peticion = solicitarEndPoint(endPoint);
    peticion.then((respuesta) => {
        let divCosenoResult = document.getElementById("cosenoResult");
        divCosenoResult.innerHTML = respuesta;
    });
}

function esPalindromo(){
    let inputPalindromo = document.getElementById("palindromo");
    let endPoint = "/palindromo?cadena=" + inputPalindromo.value;
    let peticion = solicitarEndPoint(endPoint);
    peticion.then((respuesta) => {
        let divPalindromoResult = document.getElementById("palindromoResult");
        divPalindromoResult.innerHTML = respuesta;
    });
}

function calcularMagnitud(){
    let inputxPosition = document.getElementById("xPosition");
    let inputyPosition = document.getElementById("yPosition");
    let endPoint = "/magnitud?x=" + inputxPosition.value + "&y=" + inputyPosition.value;
    let peticion = solicitarEndPoint(endPoint);
    peticion.then((respuesta) => {
        let divMagnitudResult = document.getElementById("magnitudResult");
        divMagnitudResult.innerHTML = respuesta;
    });
}

async function solicitarEndPoint(endPoint){
    return await fetch("http://localhost:"+ window.location.port + endPoint)
    .then((respuesta) => {
        if(!respuesta.ok){
            throw new Error();
        }
        return respuesta.text();
    })
    .catch((error) => alert(error));
}