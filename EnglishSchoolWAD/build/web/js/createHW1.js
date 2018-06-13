var id;
var imgpath;

var canvas = new fabric.Canvas('lienzo');
canvas.setHeight(500);
canvas.setWidth(825);

function permitirDrop(event){
	event.preventDefault();
}

function dragStart(event){
	id = event.target.id;        
}

function drop_lienzo(event){        
	imgpath = document.getElementById(id).src;

        if(id ==="textUno"){
            canvas.add(new fabric.IText('Hi!', { 
              fontFamily: 'arial black',
              left: 100, 
              top: 100
            }));
        }
        
        else if(id === "textDos"){
            canvas.add(new fabric.IText('hi!', { 
              fontFamily: 'helvetica',
              left: 100, 
              top: 100 ,
              fontSize: 30
            }));
        }
        
        else if(document.getElementById(id).className === "w3-border w3-padding"){
         fabric.Image.fromURL(imgpath, function (imagens){
		imagens.scaleToWidth(200);
		imagens.scaleToHeight(200);
		canvas.add(imagens);
		imagens.center();
            });   
        }
}
fabric.util.addListener(canvas.upperCanvasEl, 'dblclick', function (e) {
  if (canvas.findTarget(e)) {
      
        const objType = canvas.findTarget(e).type;
        var activeObject2 = canvas.getActiveObject();
        
        console.log("Objeto activo: " + activeObject2 + " Type: " + objType);
        
        if (objType === 'image') {
            var activeObject = canvas.getActiveObject();
		    canvas.remove(activeObject);
        }
    }

});

