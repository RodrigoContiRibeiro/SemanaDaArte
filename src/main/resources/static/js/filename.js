const printFileName = () => {
    const inputFile = document.querySelector("#inputImageFile");
    const paragraphFileName = document.querySelector("p.fileName");
    const uploadPreview = document.querySelector(".uploadPreview");

    const fileName = inputFile.value.split('C:\\fakepath\\').pop();
    paragraphFileName.innerHTML = `Você escolheu o arquivo ${fileName}`

    uploadPreview.src = URL.createObjectURL(inputFile.files[0])
    uploadPreview.onload = () => {
        URL.revokeObjectURL(uploadPreview.src)
    }
}