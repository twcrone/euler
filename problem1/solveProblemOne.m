#import <Foundation/Foundation.h>

int main (int argc, const char * argv[])
{

    NSAutoreleasePool * pool = [[NSAutoreleasePool alloc] init];

    int sum;
    
    for(int i = 1; i <= 1000; ++i)
    {
        if(i % 3 == 0 || i % 5 == 0)
            sum += i;
    }
    
    // insert code here...
    NSLog(@"Answer is -> %i", sum);

    [pool drain];
    return 0;
}

