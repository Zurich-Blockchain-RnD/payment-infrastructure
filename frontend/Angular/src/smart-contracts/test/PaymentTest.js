const payDefinition = artifacts.require('Payment');

contract('Payment', accounts => { 
    var owner = accounts[0]
    var contractInstance 

    beforeEach(async function () { 
        contractInstance = await payDefinition.new({from: owner})
    })

    describe('payment basics', () => { 
        it('ask for balance', async function () { 
            assert.equal(await contractInstance.getBalanceOfCurrentAccount(), 'some balance')
        })
    })
})