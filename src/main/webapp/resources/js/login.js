
/* global PF */

window.onload = function () {
    PF('buttonLogin').disable();
};

function buttonLogin(inputValidat) {
    var input = jQuery('#loginForm\\:' + inputValidat).val();
    var inputPassword = jQuery('#loginForm\\:password').val();
    var button = PF('buttonLogin');
    if (input.length >= 10 
            && inputPassword !== 'undefined'
            && inputPassword !== '') {
        button.enable();
    } else {
        button.disable(); 
    }

}

function buttonResetPassword() {
    var inputPassword = jQuery('#resetPassword\\:passwordForm').val();
    var inputPasswordConfirm = jQuery('#resetPassword\\:passwordFormConfirm').val();
    var codigo = jQuery('#resetPassword\\:codigo').val();
    var button = PF('buttonReset');
    if ((codigo !== ''
            && codigo !== 'undefined')
            && inputPassword.length >= 6
            && inputPasswordConfirm.length >= 6) {
        button.enable();
    } else {
        button.disable();
    }

}