const imgBtn = document.querySelectorAll(".imgBtn");
const imgBack = document.querySelectorAll(".boxButton img");

function mouseEnterHandler(event) {
  event.explicitOriginalTarget.nextElementSibling.style.transition =
    "all 0.25s cubic-bezier(.17,.67,.83,.67)";
  event.explicitOriginalTarget.nextElementSibling.style.opacity = 0;
}

function mouseLeaverHandler(event) {
  console.log(event.relatedTarget);
  event.relatedTarget.style.transition =
    "all 0.25s cubic-bezier(.17,.67,.83,.67)";
  event.relatedTarget.style.opacity = 1;
}

console.log(imgBtn);
