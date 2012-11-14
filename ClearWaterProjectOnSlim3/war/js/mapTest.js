J(function(){
	J('#addComment').keypress(function (e) {
		if (e.which == 13 && event.ctrlKey == false && event.altKey == false && event.shiftKey == fallse){
			var addSt = J('#addComment').val();
			J('#addComment').remove();
			J('#addCommentTr').append('<div>' + addSt + '</div>');
		}
	});
});
