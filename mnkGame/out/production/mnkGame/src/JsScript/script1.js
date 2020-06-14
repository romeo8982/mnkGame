function pickAny(list)
{
    var Element = Java.type('Element');
    var element = new Element(1,1,2);
    var flag = false;
    var row;
    var col;
    do
    {
     flag = false;
     row = Math.floor((Math.random() * 5) + 1);
     col = Math.floor((Math.random() * 5) + 1);
     for (var i = 0;i<list.length;i++)
     {
        element=list[i];
        if(element.x==parseInt(row, 10)&&element.y==parseInt(col, 10))
        {
            flag = true;
        }
     }
    }while(flag);

    var data = [parseInt(row, 10),parseInt(col, 10)];
    return data;
}