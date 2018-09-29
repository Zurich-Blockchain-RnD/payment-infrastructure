pragma solidity ^0.4.2;

contract Payments {
    address[] users;
    Provider[] providers;
    
    struct Provider {
        address providerAddress;
        string name;
        Service[] services;
    }
    
    struct Service {
        string name;
        uint8 price;
    }
    
    function becomeUser() public {
        // check if the caller is already a registered user
        
        // add caller to the user list
    }
    
    function becomeProvider() public {
        // check if the caller is already a registered provider
        
        // add caller to the provider list
    }
    
    function offerService(string serviceName, uint8 servicePrice) public {
        // caller is expected to be provider
        // check if caller is registered provider
        // check if the given service is already in the list
        
        // add service to the list of services of the given provider
    }
    
    function getProviders() public {
        // return a list of registered providers
    }
    
    function getUsers() public {
        // return a list of registered users
    }
    
    function getOffers(address provider) public {
        // check if given provider is registered
        
        // return a list of services the given provider offers
    }
    
    function makePayment(address provider, string service) public payable {
        // check if the caller is registered user
        // check if given provider is registered
        // check if given provider offers required service
        
        // make payment -> substract money from the caller, send money to the provider
    }
}