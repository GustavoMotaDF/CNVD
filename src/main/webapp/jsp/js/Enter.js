/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.location.reload(true);
document.location.reload(true);
function AnalizaTeclas()
{
    var tecla = window.event.keyCode;
    if (tecla == 13) {
        event.keyCode = 0;
        event.returnValue = false;
    }
}
window.onload AnalizaTeclas();