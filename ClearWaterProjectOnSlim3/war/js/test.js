J(function(){
	
	J('#addComment').keypress(function (e) {
		if (e.which == 13 && event.ctrlKey == false && event.altKey == false && event.shiftKey == false){
			var addSt = J('#addComment').val();
			J('#addComment').remove();
			J('#addCommentTr').append('<div>' + addSt + '</div>');
		}
	});
	
	
	J('.slidyContainer').slidy({
	});
	

	var uploadFiles = function (files) {
        // FormData オブジェクトを用意
        var fd = new FormData();

        // ファイル情報を追加する
        for (var i = 0; i < files.length; i++) {
            fd.append('files', files[i]);
        }
        
//        var xhr = new XMLHttpRequest();
//        xhr.open('POST', '/receivewaterinfo');  
//        xhr.send(fd);

        // XHR で送信
        J.ajax({
            url: '/receivewaterinfo',
            type: 'POST',
            data: fd,
            processData: false,
            contentType: false
        });
    };

    // ファイル選択フォームからの入力
    J('#form').bind('change', function () {
        // 選択されたファイル情報を取得
        var files = this.files;

        // アップロード処理
        uploadFiles(files);
    });

    // ドラッグドロップからの入力
    J('#target').bind('drop', function (e) {
        // ドラッグされたファイル情報を取得
        var files = e.originalEvent.dataTransfer.files;

        // アップロード処理
        uploadFiles(files);
    })
    .bind('dragenter', function () {
        // false を返してデフォルトの処理を実行しないようにする
        return false;
    })
    .bind('dragover', function () {
        // false を返してデフォルトの処理を実行しないようにする
        return false;
    });
});

//	parent.parent.location.reload();
	//今開いているウインドウを閉じる
//	parent.parent.GB_hide();
