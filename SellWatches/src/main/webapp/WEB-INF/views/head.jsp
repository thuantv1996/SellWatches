<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
     
<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" type="text/css" media="all" />
<!--jQuery(necessary for Bootstrap's JavaScript plugins)-->
<script src="<c:url value="/resources/js/jquery-1.11.0.min.js" />"></script>
<!--Custom-Theme-files-->
<!--theme-style-->
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Luxury Watches Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--start-menu-->
<script src="<c:url value="/resources/js/simpleCart.min.js" />"> </script>
<link href="<c:url value="/resources/css/memenu.css" />" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="<c:url value="/resources/js/memenu.js" /> "></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>	
<!--dropdown-->
<script src="<c:url value="/resources/js/jquery.easydropdown.js" /> "></script>
<link href="<c:url value="/resources/css/checkouts.css" />" rel="stylesheet" type="text/css" media="all" />
<link href="<c:url value="/resources/css/custom.css" />" rel="stylesheet" type="text/css" media="all" />
<script src="<c:url value="/resources/js/custom.js" /> "></script>

<script type="text/javascript">
                        window.onpageshow = function(event) {
                            if (event.persisted) {
                                var currentUrl = '';

                                
                                    currentUrl = 'http://happylive.vn/checkouts/913189a78ff74efa816492a0bf2c7981?step=1';
                                
                                
                                if(currentUrl)
                                    window.location = currentUrl;
                            }
                        };

						

						var isInit = false;
						
						function funcFormOnSubmit(e) {

						    if(!isInit) {
						        isInit = true;

						        $.fn.tagName = function() {
						            return this.prop("tagName").toLowerCase();
						        };
						    }

							if(typeof(e) == 'string') {
								var element = $(e);
								var formData = e;
							} else {
								var element = this;
								var formData = this;
								e.preventDefault();
							}
							
							$(element).find('button:submit').addClass('btn-loading');
							
							var formId = $(element).attr('id'), replaceElement = [], funcCallback;
					
							if(formId == undefined || formId == null || formId == '')
								return;
                            
							

								if(formId == 'form_next_step') {
									formData = '.section-customer-information';
									replaceElement.push('.step-sections');
								} 
								else if(
									formId == 'form_discount_add'
									|| formId == 'form_discount_remove'
									|| formId == 'form_update_location'
									
									) {
									replaceElement.push('#form_update_location');
									replaceElement.push('.inventory_location');
									replaceElement.push('.inventory_location_data');
									replaceElement.push('.order-summary-toggle-inner .order-summary-toggle-total-recap');
									replaceElement.push('.order-summary-sections');
								}

								

							

							if(!$(formData) || $(formData).length == 0) {
							    window.location.reload();
							    return false;
							}

							if($(formData).tagName() != 'form')
								formData += ' :input';

							$.ajax({
								type: 'GET',
								url: window.location.origin + window.location.pathname + '?' + $(formData).serialize() + encodeURI('&form_name=' + formId),
								success: function(html) {

									if($(html).attr('id') == 'redirect-url') {
										window.location = $(html).val();
									} else {
										if(replaceElement.length > 0) {
											for (var i = 0; i < replaceElement.length; i++) 
											{
												var tempElement = replaceElement[i];
												var newElement = $(html).find(tempElement);
											
												if(newElement.length > 0) {
													if(tempElement == '.step-sections')
														$(tempElement).attr('step', $(newElement).attr('step'));

													var listTempElement = $(tempElement);

													for(var j = 0; j < newElement.length; j++)
														if(j < listTempElement.length)
															$(listTempElement[j]).html($(newElement[j]).html());
												}
											}
										}

										$('body').attr('src', $(html).attr('src'));
										$(element).find('button:submit').removeClass('btn-loading');
						
										if(($('body').find('.field-error') && $('body').find('.field-error').length > 0)
                                            || ($('body').find('.has-error') && $('body').find('.has-error').length > 0))
										    $("html, body").animate({ scrollTop: 0 }, "slow");

										if(funcCallback)
											funcCallback();
									}
								}
							});

							return false;
						};
						function funcSetEvent() {
							var effectControlFieldClass = '.field input, .field select, .field textarea';
			  
							$('body')
								.on('focus', effectControlFieldClass, function() {
									funcFieldFocus($(this), true);
								})
								.on('blur', effectControlFieldClass, function() {
									funcFieldFocus($(this), false);
									funcFieldHasValue($(this), true);
								})
								.on('keyup input paste', effectControlFieldClass, function() {
									funcFieldHasValue($(this), false);
								})
								.on('submit', 'form', funcFormOnSubmit);

							
							
								

									$('body')
										.on('change', '#form_update_location', function() {
											$(this).submit();
										});

								
									
								$('body')
									.on('change', '#form_update_location select[name=customer_shipping_district]', function() {
										$('.section-customer-information input:hidden[name=customer_shipping_district]').val($(this).val());
									})
									.on('change', '#form_update_location select[name=customer_shipping_ward]', function() {
										$('.section-customer-information input:hidden[name=customer_shipping_ward]').val($(this).val());
									});

								
								
								$('body')
									.on('change', '#form_update_shipping_method input:radio', function() {
										$('#form_update_shipping_method .content-box-row.content-box-row-secondary').addClass('hidden');

										var id = $(this).attr('id');

										if(id) {
											var sub = $('body').find('.content-box-row.content-box-row-secondary[for=' + id + ']')
											
											if(sub && sub.length > 0) {
												$(sub).removeClass('hidden');
											}
										}
									});

                            
							

							
						};
						function funcFieldFocus(fieldInputElement, isFocus) {
							if(fieldInputElement == undefined)
								return;
				
							var fieldElement = $(fieldInputElement).closest('.field');

							if(fieldElement == undefined)
								return;

							if(isFocus) 
								$(fieldElement).addClass('field-active');
							else 
								$(fieldElement).removeClass('field-active');
						};
						function funcFieldHasValue(fieldInputElement, isCheckRemove) {
							if(fieldInputElement == undefined)
								return;
				
							var fieldElement = $(fieldInputElement).closest('.field');

							if(fieldElement == undefined)
								return;
								
							if($(fieldElement).find('.field-input-wrapper-select').length > 0) {
								var value = $(fieldInputElement).find(':selected').val();

								if(value == 'null')
									value = undefined;
							} else {
								var value = $(fieldInputElement).val();
							}

							if(!isCheckRemove) {
								if(value != $(fieldInputElement).attr('value'))
									$(fieldElement).removeClass('field-error');
							}

							var fieldInputBtnWrapperElement = $(fieldInputElement).closest('.field-input-btn-wrapper');

							if(value && value.trim() != '') {
								$(fieldElement).addClass('field-show-floating-label');
								$(fieldInputBtnWrapperElement).find('button:submit').removeClass('btn-disabled');
							} 
							else if(isCheckRemove) {
								$(fieldElement).removeClass('field-show-floating-label');
								$(fieldInputBtnWrapperElement).find('button:submit').addClass('btn-disabled');
							} 
							else {
								$(fieldInputBtnWrapperElement).find('button:submit').addClass('btn-disabled');
							}
						};
						function funcInit() {
							funcSetEvent();

							
						}
						$(document).ready(function() {
							funcInit();
						});
					</script>
				

				<script type="text/javascript">
					var toggleShowOrderSummary = false;
					$(document).ready(function() {
					    var currentUrl = '';

					    
					        currentUrl = 'http://happylive.vn/checkouts/913189a78ff74efa816492a0bf2c7981?step=1';
					    

					    if ($('#reloadValue').val().length == 0)
					    {
					        $('#reloadValue').val(currentUrl);
					        $('body').show();
					    }
					    else
					    {
					        window.location = $('#reloadValue').val();
					        $('#reloadValue').val('');
					    }

						$('body')
							.on('click', '.order-summary-toggle', function() {
								toggleShowOrderSummary = !toggleShowOrderSummary;

								if(toggleShowOrderSummary) {
									$('.order-summary-toggle')
										.removeClass('order-summary-toggle-hide')
										.addClass('order-summary-toggle-show');

									$('.sidebar:not(".sidebar-second") .sidebar-content .order-summary')
										.removeClass('order-summary-is-collapsed')
										.addClass('order-summary-is-expanded');
										
									$('.sidebar.sidebar-second .sidebar-content .order-summary')
										.removeClass('order-summary-is-expanded')
										.addClass('order-summary-is-collapsed');
								} else {
									$('.order-summary-toggle')
										.removeClass('order-summary-toggle-show')
										.addClass('order-summary-toggle-hide');

									$('.sidebar:not(".sidebar-second") .sidebar-content .order-summary')
										.removeClass('order-summary-is-expanded')
										.addClass('order-summary-is-collapsed');
										
									$('.sidebar.sidebar-second .sidebar-content .order-summary')
										.removeClass('order-summary-is-collapsed')
										.addClass('order-summary-is-expanded');
								}
							});
					});
				</script>