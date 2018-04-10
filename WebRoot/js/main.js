/**
 * Created by ajax on 2018/3/14.
 */
$().ready(function() {
    $("#login_form").validate({
        rules: {
            username: "required",
            password: {
                required: true,
                minlength: 5
            },
        },
        messages: {
            username: "����������",
            password: {
                required: "����������",
                minlength: jQuery.format("���벻��С��{0}���� ��")
            },
        }
    });
    $("#register_form").validate({
        rules: {
            username: "required",
            password: {
                required: true,
                minlength: 5
            },
            rpassword: {
                equalTo: "#register_password"
            },
            email: {
                required: true,
                email: true
            }
        },
        messages: {
            username: "����������",
            password: {
                required: "����������",
                minlength: jQuery.format("���벻��С��{0}���� ��")
            },
            rpassword: {
                equalTo: "�������벻һ��"
            },
            email: {
                required: "����������",
                email: "��������Ч����"
            }
        }
    });
});
$(function() {
    $("#register_btn").click(function() {
        $("#register_form").css("display", "block");
        $("#login_form").css("display", "none");
    });
    $("#back_btn").click(function() {
        $("#register_form").css("display", "none");
        $("#login_form").css("display", "block");
    });
});