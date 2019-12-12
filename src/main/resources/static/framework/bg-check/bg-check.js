
createStar();

function createStar() {
  for (var i = 0; i <= 40; i++) {
    var star = this.newStar();
    star.style.top = Math.random() * 100 + "%";
    star.style.left = Math.random() * 100 + "%";
    star.style.width ="7.5px";
    star.style.height = "7.5px";
    star.animation = 'none';
    star.style.backgroundColor="white";
    star.style.boxShadow="1px 1px 10px lightblue";
     star.style.opacity= Math.random()/2+0.2;
    document.body.appendChild(star);
  }
}

function newStar() {
  var d = document.createElement('div');
  d.innerHTML = '<div class="star">';
  return d.firstChild;
}