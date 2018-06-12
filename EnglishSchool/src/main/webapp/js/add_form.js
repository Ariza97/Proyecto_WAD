var id;
var estado;

var imgpath;
var canvas = new fabric.Canvas('canvas');
canvas.setHeight(500);
canvas.setWidth(825);
function permitirDrop(event) {
    event.preventDefault();
}

function dragStart(event) {
    id = event.target.id;
}
//Simple shapes
function addRect(event) {
    var coord = getRandomLeftTop();
    canvas.add(new fabric.Rect({
        left: coord.left,
        top: coord.top,
        fill: '#' + getRandomColor(),
        width: 50,
        height: 50,
        opacity: 0.8
    }));
}
function addCircle(event) {
    var coord = getRandomLeftTop();
    canvas.add(new fabric.Circle({
        left: coord.left,
        top: coord.top,
        fill: '#' + getRandomColor(),
        radius: 50,
        opacity: 0.8
    }));
}
function addTriangule(event) {
    var coord = getRandomLeftTop();
    canvas.add(new fabric.Triangle({
        left: coord.left,
        top: coord.top,
        fill: '#' + getRandomColor(),
        width: 50,
        height: 50,
        opacity: 0.8
    }));
}
function addLine(event) {
    var coord = getRandomLeftTop();
    canvas.add(new fabric.Line([50, 100, 200, 200], {
        left: coord.left,
        top: coord.top,
        stroke: '#' + getRandomColor()
    }));
}
function addtext(event) {
    var text = 'Title!';
    var textSample = new fabric.Text(text, {
        left: getRandomInt(350, 400),
        top: getRandomInt(350, 400),
        fontFamily: 'arial black',
        scaleX: 0.5,
        scaleY: 0.5,
        fontWeight: '',
        originX: 'left',
        hasRotatingPoint: true,
        centerTransform: true

    });
    canvas.add(textSample);
}
function addtextBox(event) {
    var text = 'Titleless';
    var textSample = new fabric.IText(text, {
        left: getRandomInt(350, 400),
        top: getRandomInt(350, 400),
        fontFamily: 'helvetica',
        angle: getRandomInt(-10, 10),
        fill: '#' + getRandomColor(),
        scaleX: 0.5,
        scaleY: 0.5,
        fontWeight: '',
        originX: 'left',
        hasRotatingPoint: true,
        centerTransform: true
    });
    canvas.add(textSample);
}
//Emojis
function addImage(imageName, minScale, maxScale) {
    var coord = getRandomLeftTop();
    fabric.Image.fromURL('../Pictures/' + imageName, function (image) {
        image.set({
            left: coord.left,
            top: coord.top,
            angle: getRandomInt(-10, 10)
        })
                .scale(getRandomNum(minScale, maxScale))
                .setCoords();
        canvas.add(image);
    });
}
function image_1(event) {
    addImage("emoji_1.png", 0.1, 0.25);
}
function image_2(event) {
    addImage("emoji_2.png", 0.1, 0.25);
}
function image_3(event) {
    addImage("emoji_3.png", 0.1, 0.25);
}
function image_4(event) {
    addImage("emoji_4.png", 0.1, 0.25);
}
function image_5(event) {
    addImage("emoji_5.png", 0.1, 0.25);
}
//Object-control
function setHorizontalLock(value) {
    setActiveProp('lockMovementX', value);
}
function getHorizontalLock(event) {
    return getActiveProp('lockMovementX');
}
//Save area
function saveJSON(event) {
    estado = JSON.stringify(canvas);
    alert(estado);
    return estado;
}

function loadJSON() {
    cargar(estado);
}
function cargar(json) {
    estado =json;
    canvas.loadFromJSON(json, function () {
        canvas.renderAll();
    });
}


//Deleted area
function clearAll(event) {
    //if (confirm('Are you sure?')) {
    canvas.clear();
    //}
}
function removeSelected(event) {
    var activeObjects = canvas.getActiveObjects();
    canvas.discardActiveObject();
    if (activeObjects.length) {
        canvas.remove.apply(canvas, activeObjects);
    }
}

function getActiveObjects(event) {
    var active = this._activeObject;
    if (active) {
        if (active.type === 'activeSelection' && active._objects) {
            return active._objects.slice(0);
        } else {
            return [active];
        }
    }
    return [];
}
function discardActiveObject() {
    var currentActives = this.getActiveObjects();
    if (currentActives.length) {
        this.fire('before:selection:cleared', {target: currentActives[0], e: e});
    }
    this._discardActiveObject(e);
    this._fireSelectionEvents(currentActives, e);
    return this;
}

function drop_lienzo(event) {
    imgpath = document.getElementById(id).src;
    if (id === "textUno") {
        canvas.add(new fabric.IText('Hi!', {
            fontFamily: 'arial black',
            left: 100,
            top: 100
        }));
    } else if (id === "textDos") {
        canvas.add(new fabric.IText('hi!', {
            fontFamily: 'helvetica',
            left: 100,
            top: 100,
            fontSize: 30
        }));
    } else if (document.getElementById(id).className === "w3-border w3-padding") {
        fabric.Image.fromURL(imgpath, function (imagens) {
            imagens.scaleToWidth(200);
            imagens.scaleToHeight(200);
            canvas.add(imagens);
            imagens.center();
        });
    }
}

