<script>
  $('#myButton').on('click', function () {
    var $btn = $(this).button('loading')

    $btn.button('reset')
  })
</script>