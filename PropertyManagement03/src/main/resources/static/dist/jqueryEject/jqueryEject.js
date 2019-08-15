/**
 *	1、alert弹窗调用示例：
 *	Ealt.Ealert({
 *	      title:'alert提示文案',
 *	      message:'这是alert弹窗，感觉还是很不错的'
 *	})
 *	2、confirm弹窗调用示例：
 *	Ealt.Econfirm({
 *	      title:'confirm弹窗文案',
 *	      message:'这是confirm弹窗,你确定删除吗?',
 *	      define:function(){
 *	            alert('您点击了确定')
 *	      },
 *	      cancel:function(){
 *	            alert('您点击了取消')
 *	      }
 *	})
 *	3、toast弱提示调用示例：
 *	Ealt.Etoast('这是toast弱提示，您觉得怎么样！',3)//默认三秒 
 */

function Eject() {
	var _this = this;
	var qback = $('<div class="qback"></div>')
	_this.Ealert = function(obj) {
		$(".qback .alertBox").remove();
		var alertBox = $('<div class="alertBox"></div>')
		var alertHead = $('<div class="alertHead">' + obj.title + '</div>')
		var alertMes = $('<div class="alertMes">' + obj.message + '</div>')
		var alertBtn = $('<span class="alertBtn">确定</span>').on('click', function() {
			qback.remove();
			alertBox.remove();
		})
		alertBox.append(alertHead);
		alertBox.append(alertMes);
		alertBox.append(alertBtn);
		qback.append(alertBox);
		$('body').append(qback);
		alertBox.css({
			'marginTop': -alertBox.outerHeight() / 2 + 'px'
		});
	}
	_this.Econfirm = function(obj) {
		$(".qback .alertBox").remove();
		var confirmBox = $('<div class="alertBox"></div>')
		var confirmHead = $('<div class="alertHead">' + obj.title + '</div>')
		var confirmMes = $('<div class="alertMes">' + obj.message + '</div>')
		var confirmBtn = $('<span class="ConBtn">确定</span>').on('click', function() {
			qback.remove()
			confirmBox.remove()
			setTimeout(function() {
				obj.define()
			}, 100)
		})
		var confirmcancel = $('<span class="cancel">取消</span>').on('click', function() {
			qback.remove()
			confirmBox.remove()
			setTimeout(function() {
				obj.cancel()
			}, 100)
		})
		confirmBox.append(confirmHead);
		confirmBox.append(confirmMes);
		confirmBox.append(confirmBtn);
		confirmBox.append(confirmcancel);
		qback.append(confirmBox);
		$('body').append(qback);
		confirmBox.css({
			'marginTop': -confirmBox.outerHeight() / 2 + 'px'
		});
	}, _this.Etoast = function(mes, time) {
		var timer = null;
		var ToastBox = $('<div class="ToastBox">' + mes + '</div>')
		qback.append(ToastBox);
		$('body').append(qback);
		ToastBox.css({
			'marginTop': -ToastBox.outerHeight() / 2 + 'px'
		});
		clearInterval(timer)
		timer = setInterval(function() {
			time--
			if(time <= 0) {
				clearInterval(timer)
				qback.remove()
				ToastBox.remove()
			}
		}, 1000)
	}
}

var jqueryEject = new Eject();
