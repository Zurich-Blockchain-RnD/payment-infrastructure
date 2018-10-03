pragma solidity ^0.4.2;

contract Payments {
    mapping(address => bool) private users;
    address[] private usersArray;
    mapping(string => bool) providers;
    Provider[] providersArray;
    
    struct Provider {
        address providerAddress;
        string name;
        Service[] services;
    }
    
    struct Service {
        string name;
        uint8 price;
    }
    
    function addUser() public {
        // check if the caller is already a registered user
        if (!users[msg.sender]) {
            // add caller to the users array and mapping
            users[msg.sender] = true;
            usersArray.push(msg.sender);
        }
    }
    
    function addProvider(string providerName) public {
        // check if the caller is already a registered provider
        if (!providers[providerName]) {
            // temporary solution, we need to change declaration to unlimited array
            Service[] memory services = new Service[](5);
            // add caller to the providers array and mapping
            Provider memory newProvider = Provider({
                providerAddress: msg.sender,
                name: providerName,
                services: services
            });
            
            providers[providerName] = true;
            providersArray.push(newProvider);
        }
    }
    
    function offerService(string serviceName, uint8 servicePrice) public {
        // caller is expected to be provider
        // check if caller is registered provider
        // check if the given service is already in the list
        
        // add service to the list of services of the given provider
    }
    
    // Originally, we wanted to return an array of structs Provider, but Solidity does NOT support it
    // we need to come up with solution when the function will return either an array of providers
    // or at least one particular provider
    function getProviders() public {
        // return a list of registered providers
    }
    
    function getUsers() public view returns (address[]) {
        // return a list of registered users
        return usersArray;
    }
    
    function getOffers(address provider) public {
        // check if given provider is registered
        
        // return a list of services the given provider offers
    }
    
    function makePayment(address provider, string service) public payable {
        // check if the caller is registered user
        // check if given provider is registered
        // check if given provider offers required service
        
        // make payment -> substract money from caller, send money to the provider
    }
}