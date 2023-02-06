package com.backend.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.Entity.Cart;
import com.backend.Entity.Currency;

import com.backend.Entity.User;
import com.backend.Repo.CartRepo;
import com.backend.Repo.UserRepo;
import com.backend.Service.CartService;
import com.backend.Service.CurrencyService;
import com.backend.Service.UserService;

@RestController

@CrossOrigin(origins="*")
@RequestMapping(value="/user")
public class UserRestController {

	
	
	

 @Autowired
 UserService userService;

 // Configures my endpoint, /signup in the end url, accepts JSON data, Produces JSON data, accessed with a post
 @Autowired
 CurrencyService currencyService;
 
 
 @Autowired
 CartService cartService;
 
 @Autowired 
 CartRepo cartRepo;
 
 @RequestMapping(
 		value = "/signUp",
 		consumes = MediaType.APPLICATION_JSON_VALUE,
 		produces = MediaType.APPLICATION_JSON_VALUE,
 		method = RequestMethod.POST
 		)
 // We return a ResponseEntity<Object> because the object returned may vary, could be user, could be an error
 // The RequestBody is the information sent to us to process, post and put has request body, get and delete do not
 // Request body is encrypted, always send password through a post request
 public ResponseEntity<Object> signUp(@RequestBody User user) {
 	// Wrap your endpoints in a try catch, if an error happens at any points, you return that error to the client
     try {
         User signedInUser = userService.save(user);
 
         // Give proper status codes, OK 200, BadRequest 400, INTERNAL_SERVER_ERROR 500
         return new ResponseEntity<>(signedInUser, HttpStatus.OK);
     } catch(Exception e) {
         return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
     } catch(Error e) {
         return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
     }
 }

 @RequestMapping(value = "/signIn",
         consumes = MediaType.APPLICATION_JSON_VALUE,
         produces = MediaType.APPLICATION_JSON_VALUE,
         method = RequestMethod.POST
         )
 public ResponseEntity<Object> signIn(@RequestBody User user) {

     try {
         User signedInUser = userService.signIn(user);
         
         if(signedInUser == null) {
             
             throw new Error("No user found");
             
         }
 
         return new ResponseEntity<>(signedInUser, HttpStatus.OK);
         
     } catch(Exception e) {
         return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
     } catch(Error e) {
         return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
     }
 }
 
 // Path variables can be sent here too, same way with {} to say where they will be
 @RequestMapping(
         value="/getByEmail/{email}",
         consumes = MediaType.APPLICATION_JSON_VALUE,
         produces = MediaType.APPLICATION_JSON_VALUE,
         method = RequestMethod.GET
         )
 // Grab the path variable same way as before, with annotation @PathVariable
 public ResponseEntity<Object> getUserByEmail(@PathVariable String email) {
     
     try {
         User foundUser = userService.getUserByEmail(email);
         
         return new ResponseEntity<>(foundUser, HttpStatus.OK);
     }catch (Exception e) {
         return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
     } catch (Error e) {
         return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
     }
 }
 
 @RequestMapping(
	        value="/update",
	        consumes = MediaType.APPLICATION_JSON_VALUE,
	        produces = MediaType.APPLICATION_JSON_VALUE,
	        method = RequestMethod.POST
	    )
	    public ResponseEntity<Object> updateUser(@RequestBody User user) {

	        try {

	            User updatedUser = userService.updateUser(user);
	            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	        
	        } catch(Exception e) {
	            System.out.println(e.getMessage());
	            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	        } catch(Error e) {
	            System.out.println(e.getMessage());
	            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        }

	    }
 
 
 @RequestMapping(
    value="/deleteUserById/{userId}",
    produces = MediaType.APPLICATION_JSON_VALUE,
    method = RequestMethod.DELETE
)
public ResponseEntity<Object> deleteById(@PathVariable Integer userId) {

    try {

        userService.deleteUserById(userId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    } catch(Exception e) {
        System.out.println(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    } catch(Error e) {
        System.out.println(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
 
 @RequestMapping(value = "/updateSignIn",
         consumes = MediaType.APPLICATION_JSON_VALUE,
         produces = MediaType.APPLICATION_JSON_VALUE,
         method = RequestMethod.POST
         )
 public ResponseEntity<Object> UpdateSignIn(@RequestBody User user) {

     try {
         User signedInUser = userService.signIn(user);
         
         if(signedInUser == null) {
             
             throw new Error("No user found");
             
         }
 
         return new ResponseEntity<>(signedInUser, HttpStatus.OK);
         
     } catch(Exception e) {
         return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
     } catch(Error e) {
         return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
     }
 }
 
 
// @RequestMapping(value = "/purchase/{cartId}",
//         consumes = MediaType.APPLICATION_JSON_VALUE,
//         produces = MediaType.APPLICATION_JSON_VALUE,
//         method = RequestMethod.POST
//         )
// public ResponseEntity<Object> purchaseCartItems(@RequestBody User user , @PathVariable Integer cartId ) {
//
//     try {
//    	 Integer userId = user.getId();
//    	 
//    	 User purchase = userService.buyCurrency(userId,cartId);
//    	 
//         
//         if(purchase == null) {
//             
//             throw new Error("Invalid purchase");
//             
//         }
// 
//         return new ResponseEntity<>(purchase, HttpStatus.OK);
//         
//     } catch(Exception e) {
//         return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//     } catch(Error e) {
//         return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//     }
// }
// @RequestMapping(value = "/postItemsInCart/{Id}",
//         consumes = MediaType.APPLICATION_JSON_VALUE,
//         produces = MediaType.APPLICATION_JSON_VALUE,
//         method = RequestMethod.POST
//         )
// public ResponseEntity<Object> postCart(@PathVariable Integer Id) {
//
//     try {
//    	 
//    	 User postCurrency = userService.findById(Id);
//    	 
//    			
//         
//         if(postCurrency == null) {
//             
//             throw new Error("Invalid");
//             
//         }
// 
//         return new ResponseEntity<>(postCurrency, HttpStatus.OK);
//         
//     } catch(Exception e) {
//         return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//     } catch(Error e) {
//         return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//     }
// }
// 
// @RequestMapping(value = "/getItemsInCart/{Id}",
//         produces = MediaType.APPLICATION_JSON_VALUE,
//         method = RequestMethod.GET
//         )
// public ResponseEntity<Object> getCart(@PathVariable Integer Id) {
//
//     try {
//    	 
//    	 User getCurrency = userService.getById(Id);
//    	 
//    			
//         
//         if(getCurrency == null) {
//             
//             throw new Error("Invalid ");
//             
//         }
// 
//         return new ResponseEntity<>(getCurrency, HttpStatus.OK);
//         
//     } catch(Exception e) {
//         return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//     } catch(Error e) {
//         return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//     }
// }
// 
// @RequestMapping(value = "/purchaseCart/{cartId}/{userId}",
//         consumes = MediaType.APPLICATION_JSON_VALUE,
//         produces = MediaType.APPLICATION_JSON_VALUE,
//         method = RequestMethod.POST
//         )
// public ResponseEntity<Object> purchaseCurrencyFromCart(@RequestBody User user , @PathVariable Integer cartId  , @PathVariable Integer userId) {
//
//     try {
//    	 
//    	 
//    	 User purchase = userService.buyCurrencyFromCart(cartId, userId);
//    	 
//         
//         if(purchase == null) {
//             
//             throw new Error("Invalid purchase");
//             
//         }
// 
//         return new ResponseEntity<>(purchase, HttpStatus.OK);
//         
//     } catch(Exception e) {
//         return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//     } catch(Error e) {
//         return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//     }
// }
//
 
 
 
 

}


