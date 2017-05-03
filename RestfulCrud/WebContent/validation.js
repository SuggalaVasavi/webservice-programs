function validateForm()

{

  

 var x=document.forms["form1"]["firstname"];

 if (x.value=="")

   {

  alert("Please enter the First name.");

  x.focus();

  return false;

   }

 else if(x.value.length>20)

   {

   alert("First name cannot be greater than 20 characters.");

  x.value="";

  x.focus();

  return false;

   }

 else if ((!namepattern.test(x.value)))

   {

  alert("First name should contain only alphabets.");

  x.value="";

  x.focus();

  return false;

   }

 x=document.forms["form1"]["lastname"];

 if(x.value=="")

   {

  alert("Please enter the Last name.");

  x.focus();

  return false;

 }

  else if(x.value.length>20)

   {

  alert("Last name cannot be greater than 20 characters.");

  x.value="";

  x.focus();

  return false;

 }

 else if (!namepattern.test(x.value))

   {

    alert("Last name should contain only alphabets.");

  x.value="";

  x.focus();

  return false;

 }

 

 x=document.form1.email;

 if(!emailpattern.test(x.value))
111
 {

  alert("Invalid email id.");

  x.value="";

  x.focus();

  return false;

 }

 if(confirm("Do you want to submit the form?"))

{



}

else

return false;

}


 function confirmreset()

 {

  return confirm("Do you want to reset the form?");

 }
