function pickAny(list)
{
    var EndChecker = Java.type('EndChecker');
    var endChecker = new EndChecker();
    var Element = Java.type('Element');
    for(var i=1;i<6;i++)
    {
        for(var j=1;j<6;j++)
        {
            if(!EndChecker.isLegal(list,i,j))
            {
             var element = new Element(i,j,79);
             list.add(element);
             if(EndChecker.end(list)=="O")
             {

                list.remove(list.size()-1);
                return[i,j];
             }
             list.remove(list.size()-1);
            }
        }
    }

    for(var i=1;i<6;i++)
    {
        for(var j=1;j<6;j++)
        {
           if(!EndChecker.isLegal(list,i,j))
           {
            var element = new Element(i,j,88);
            list.add(element);
            if(EndChecker.end(list)=="X")
            {
               list.remove(list.size()-1);
               return[i,j];
            }
            list.remove(list.size()-1);
           }
        }
    }
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
   pickAny(list)
}
