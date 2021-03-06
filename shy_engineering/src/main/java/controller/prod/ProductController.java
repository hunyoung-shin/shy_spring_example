package controller.prod;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.ProdOrderCommand;
import command.ProductCommand;
import service.product.CartAddService;
import service.product.CartListService;
import service.product.CartQtyDownService;
import service.product.PaymentService;
import service.product.ProdOrderService;
import service.product.ProductAutoNumService;
import service.product.ProductBuyService;
import service.product.ProductDeleteService;
import service.product.ProductInfoService;
import service.product.ProductJoinService;
import service.product.ProductListService;
import service.product.ProductModifyService;
import service.product.PurchaseListService;
import service.product.ReviewModifyService;
import service.product.ReviewUpdateService;
import service.product.ReviewWriteService;

@Controller
@RequestMapping("prod")
public class ProductController {
	@Autowired
	ProductAutoNumService productAutoNumService;
	@Autowired
	ProductJoinService productJoinService;
	@Autowired
	ProductListService productListService;
	@Autowired
	ProductInfoService productInfoService;
	@Autowired
	ProductModifyService productModifyService;
	@Autowired
	ProductDeleteService productDeleteService;
	@Autowired
	CartAddService cartAddService;
	@Autowired
	CartListService cartListService;
	@Autowired
	CartQtyDownService cartQtyDownService;
	@Autowired
	ProductBuyService productBuyService;
	@Autowired
	ProdOrderService prodOrderService;
	@Autowired
	PurchaseListService purchaseListService;
	@Autowired
	PaymentService paymentService;
	@Autowired
	ReviewWriteService reviewWriteService;
	@Autowired
	ReviewModifyService reviewModifyService;
	@Autowired
	ReviewUpdateService reviewUpdateService;

	@RequestMapping("prodList")
	public String prodList(Model model) {
		productListService.prodList(model);
		return "product/productList";
	}
	@RequestMapping("prodJoin")
	public String prodJoin(Model model) {
		productAutoNumService.autoNum(model);
		return "product/productForm";
	}
	@RequestMapping("prodJoinOk")
	public String prodJoinOk(ProductCommand productCommand, HttpSession session) {
		productJoinService.prodJoin(productCommand, session);
		return "redirect:prodList";
	}
	@RequestMapping("prodUpdate")
	public String prodUpdate(@RequestParam(value="prodNo") String prodNo, Model model) {
		productInfoService.prodInfo(model, prodNo);
		return "product/prodInfo";
	}
	@RequestMapping(value="prodModifyOk", method = RequestMethod.POST)	// ?????? ??????
	public String prodModifyOk(ProductCommand productCommand) {
		productModifyService.prodUpdate(productCommand);
		return "redirect:prodList";
	}
	@RequestMapping("prodDel")
	public String prodDel(@RequestParam(value="prodNo") String prodNo, HttpSession session) {
		productDeleteService.prodDel(prodNo, session);
		return "redirect:prodList";
	}
	@RequestMapping("prodInfo")
	public String prodInfo(@RequestParam(value="prodNo") String prodNo, Model model) {
		productInfoService.prodInfo(model, prodNo);
		return "product/prodDetail";
	}
	@RequestMapping("cartList")
	public String cartList(HttpSession session, Model model) {
		cartListService.cartList(session, model);
		return "product/cartList";
	}
	@RequestMapping("cartAdd")
	public String cartAdd(@RequestParam(value="prodNo") String prodNo,
							@RequestParam(value="cartQty") String cartQty,
							@RequestParam(value="prodPrice") String prodPrice,
							@RequestParam(value="catNum") String catNum,
							Model model, HttpSession session) {
		cartAddService.cartAdd(prodNo, cartQty, prodPrice, catNum, session);
		return "redirect:cartList";
	}
	@RequestMapping("prodCartQtyDown")
	public String prodCartQtyDown(@RequestParam(value="prodNo") String prodNo,
									@RequestParam(value="prodPrice") String prodPrice,
									HttpSession session) {
		cartQtyDownService.CartQtyDown(prodNo, prodPrice, session);
		return "redirect:cartList";
	}
	@RequestMapping("prodBuy")
	public String prodBuy(@RequestParam(value="prodCk") String prodCk[],
										// 2????????? ???????????? ????????? ?????????????????? -> ????????? ?????? ?????????
							Model model, HttpSession session) {
		productBuyService.prodBuy(session, prodCk, model);
		return "product/order";
	}
	@RequestMapping("prodOrder")
	public String prodOrder(ProdOrderCommand prodOrderCommand, HttpSession session) {
		String purchNo = prodOrderService.prodOrder(prodOrderCommand, session);
		return "redirect:paymentOk?purchNo="+purchNo+"&payPrice="+prodOrderCommand.getPurchTotal();
	}
	@RequestMapping("purchCon")
	public String purchCon(HttpSession session, Model model) {
		purchaseListService.purchList(session, model);
		return "product/purchCon";
	}
	@RequestMapping("paymentOk")
	public String paymentOk(@RequestParam(value="purchNo") String purchNo,
							@RequestParam(value="payPrice") String payPrice, Model model) {
		model.addAttribute("purchNo", purchNo);
		model.addAttribute("payPrice", payPrice);
		return "product/payment";
	}
	@RequestMapping("doPayment")
	public String doPayment(@RequestParam(value="purchNo") String purchNo,
							@RequestParam(value="payPrice") String payPrice,
							@RequestParam(value="payCardBank") String payCardBank,
							@RequestParam(value="payAccNum") String payAccNum,
							HttpSession session) {
		paymentService.payment(purchNo, payPrice, payCardBank, payAccNum, session);
		return "redirect:purchCon";
	}
	@RequestMapping("prodReview")
	public String prodReview(@RequestParam(value="purchNo") String purchNo,
								@RequestParam(value="prodNo") String prodNo,
								@RequestParam(value="prodName") String prodName,
								Model model) {
		model.addAttribute("purchNo", purchNo);
		model.addAttribute("prodNo", prodNo);
		model.addAttribute("prodName", prodName);
		return "product/prodReview";
	}
	@RequestMapping("reviewOk")
	public String reviewOk(@RequestParam(value="prodNo") String prodNo,
							@RequestParam(value="purchNo") String purchNo,
							@RequestParam(value="reviewContent") String reviewContent) {
		reviewWriteService.reviewWrite(prodNo, purchNo, reviewContent);
		return "redirect:purchCon";
	}
	@RequestMapping("prodReviewUpdate")
	public String prodReviewUpdate(@RequestParam(value="purchNo") String purchNo,
									@RequestParam(value="prodNo") String prodNo,
									@RequestParam(value="prodName") String prodName,
									Model model) {
		reviewUpdateService.reviewUpdate(prodNo, purchNo, prodName, model);
		return "product/prodReviewUpdate";
	}
	@RequestMapping("reviewUpdateOk")
	public String reviewUpdateOk(@RequestParam(value="purchNo") String purchNo,
									@RequestParam(value="prodNo") String prodNo,
									@RequestParam(value="reviewContent") String reviewContent) {
		reviewModifyService.reviewUpdate(purchNo, prodNo, reviewContent);
		return "redirect:purchCon";
	}
	
}
