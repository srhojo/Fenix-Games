
$(function () {

    //$("#playResult").hide();

    $('#verifyPlayerModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget)
        var recipient = button.data('player')
        var modal = $(this)
        modal.find('.modal-title').text('Verificación para ' + recipient)
        modal.find('div .modal-body').text('¿Seguro que eres tu '+recipient+'? ¡No hagas trampas que te veo!');

        $('#playButtonConfirm').on('click', function(){

            $.post("/games/jugar/"+recipient).done(function(data){
                console.log(data.asignado);
                modal.modal('hide')
                $("#playersView").removeClass("d-flex");
                $("#playersView").addClass("d-none");


                $("#playResult").removeClass("d-none");
                $("#playResult").addClass('d-flex');
                $("#playResult h3").html("¡Enhorabuena <b>"+recipient+"</b>! Te ha tocado <b>"+data.asignado+"</b>.")
                $("#playResult .content").text("¡Seguro que le encanta tu regalo!, pero recuerda, el tope de gasto son 60€.")
            })

        })

    })


});
